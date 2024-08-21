import { FormEvent, useState } from "react";

const SubmitPaste = () => {
  const [paste, setPaste] = useState("");
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
  return (
    <>
      <form onSubmit={onSubmitPaste}>
        <input name="paste" onChange={(e) => setPaste(e.target.value)} />
        <button>Upload</button>
      </form>
      <div>{returnedId}</div>
    </>
  );
};

export default SubmitPaste;
