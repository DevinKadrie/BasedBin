import { FormEvent, useState } from "react";

const RetrievePaste = () => {
  const [id, setId] = useState("");
  const [retrievedPaste, setRetrievedPaste] = useState("");

  const onSubmitGet = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const response = await fetch(`http://localhost:8080/pastes/${id}`);
    const paste = await response.text();
    setRetrievedPaste(paste);
  };

  return (
    <>
      <form onSubmit={onSubmitGet}>
        <input name="id" onChange={(e) => setId(e.target.value)} />
        <button>Retrieve</button>
      </form>
      <div>{retrievedPaste}</div>
    </>
  );
};

export default RetrievePaste;
