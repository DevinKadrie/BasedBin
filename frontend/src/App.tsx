import { ReactDOM } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginForm from "./pages/LoginForm";
import PasteSearch from "./pages/PasteSearch";
import RegistrationForm from "./pages/RegistrationPage";


const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginForm/>}/>
          <Route path="search" element={<PasteSearch/>}/>
          <Route path="register" element={<RegistrationForm/>}/>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
