import { FormEvent, useState } from "react";

const App = () => {
  const [paste, setPaste] = useState("");
  const [retrievedPaste, setRetrievedPaste] = useState("");
  const [id, setId] = useState("");
  const [returnedId, setReturnedId] = useState("");

  const onSubmitPaste = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const response = await fetch("http://localhost:8080/", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ content: paste }),
    });
    setReturnedId(await response.text());
  };

  const onSubmitGet = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const response = await fetch(`http://localhost:8080/${id}`);
    const paste = await response.text();
    setRetrievedPaste(paste);
  };

  return (
    <>
      <form onSubmit={onSubmitPaste}>
        <input name="paste" onChange={(e) => setPaste(e.target.value)} />
        <button>Upload</button>
      </form>
      <div>{returnedId}</div>

      <form onSubmit={onSubmitGet}>
        <input name="id" onChange={(e) => setId(e.target.value)} />
        <button>Retrieve</button>
      </form>

      <div>{retrievedPaste}</div>
    </>
  );
};

export default App;
