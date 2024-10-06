import { useNavigate } from "react-router-dom";
import { FormEvent ,useState} from "react"

const RegistrationForm = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");


  let navigate = useNavigate()

  //TODO: dont send plaintext password
  //TODO: handle if account already in system
  const register = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault()
    await fetch("http://localhost:8080/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          username : username,
          password : password
        }),
      });

    let path = "/"
    navigate(path)
  }

  return (
    <>
      <form onSubmit = {register}>
        <input name="userName" onChange={(e)=> setUsername(e.target.value)} />
        <input name = "passWord" onChange={(f) => setPassword(f.target.value)}/>
        <button>Register</button>
      </form>
    </>
  );
}

export default RegistrationForm;