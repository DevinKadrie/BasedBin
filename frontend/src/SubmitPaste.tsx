import { FormEvent, useState } from "react";

const SubmitPaste = () => {
  const [paste, setPaste] = useState("");
  const [returnedUrl, setReturnedUrl] = useState("");

  const onSubmitPaste = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const response = await fetch("http://localhost:8080/pastes", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ content: paste }),
    });
    setReturnedUrl(await response.text());
  };
  return (
    <>
      <form onSubmit={onSubmitPaste}>
        <input name="paste" onChange={(e) => setPaste(e.target.value)} />
        <button>Upload</button>
      </form>
      <div>{returnedUrl}</div>
    </>
  );
};

export default SubmitPaste;
