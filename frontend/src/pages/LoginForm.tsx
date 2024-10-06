import { FormEvent, useState } from "react";
import { useNavigate } from "react-router-dom";

const LoginForm = () => {
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")

  let navigate = useNavigate()

  const onLogin = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault()
    const response = await fetch("http://localhost:8080/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username : username,
        password : password
      }),
  });
    if(response.status === 200){
      console.log("good")
      navigate("/search")
    }
    //TODO: display nice error message when login not found
    else{
      console.log("bad")
      navigate("/")
    }
  }

  const registration = () => {
    let path = "/register"
    navigate(path)
  }

  //only reroute to post search if login is successful
  // send login request, if ok, then reroute, otherwise, display error message
  return (
    <>
      <form onSubmit={onLogin}>
        <input name="userName" onChange={(e)=> setUsername(e.target.value)}/>
        <input name = "passWord" onChange={(f)=> setPassword(f.target.value)}/>
        <button>Login</button>
      </form>
      <button onClick = {registration}>
        Register
      </button>
    </>
  );
}

export default LoginForm;