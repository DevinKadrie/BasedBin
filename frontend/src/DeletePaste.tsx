import { FormEvent, useState } from "react";

const RetrievePaste = () => {
  const [id, setId] = useState("");
  const [response, setResponse] = useState("");

  const onSubmitGet = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const response = await fetch(`http://localhost:8080/pastes/${id}`, { method: "DELETE" });
    setResponse(response.ok ? "Deleted!" : await response.text())
  };

  return (
    <>
      <form onSubmit={onSubmitGet}>
        <input name="id" onChange={(e) => setId(e.target.value)} />
        <button>Delete</button>
      </form>
      <div>{response}</div>
    </>
  );
};

export default RetrievePaste;