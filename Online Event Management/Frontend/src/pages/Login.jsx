import React, { useState , useEffect } from "react";
import { Link } from "react-router-dom";
import { Footer, Navbar } from "../components";
import { signIn } from "../Services/userService";
import { ToastContainer, toast } from "react-toastify";


const Login = () => {
     
  const showToastMessage = () => {
    toast.error({...errors});
  };
     let temp = {};
     const [errors,setErrors] = useState({});
     const [isSubmit,setIsSubmit] = useState(false);
     const [response,setResponse] = useState(false);
     const [loginDetail,setLoginDetail] = useState({
      email : '',
      password : ''
     })  
     const [submit,setSubmit] = useState(false);

     const handleChange = (event,property) =>
     {
      setLoginDetail({...loginDetail,[property]:event.target.value});
     }
     
     useEffect(()=>{
      if(Object.keys(errors).length === 0 && isSubmit)
      {   
          console.log();
          signIn(loginDetail).then((response)=>{toast.success("login succesfully")
      
          }).catch((error) => {toast.error("user not found !");});
        }
        else
        {
          showToastMessage();
        
        }
       
    },[errors])

    
     const validate = (loginDetail) =>
     {
        const error = {};
        if(!loginDetail.email)
        error.email = "email is required"

        if(!loginDetail.password)
        error.email = "password is required"

        return error;
          
     }
     const handleSubmit = (event)=>
     {
      event.preventDefault();
      setErrors(validate(loginDetail));
      setSubmit(true); 

     }
  return (
    <>
      <Navbar/>
      <div className="container my-3 py-3">
        <h1 className="text-center">Login</h1>
        <hr />
        <div class="row my-4 h-100">
          <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
            <form onSubmit={handleSubmit}>
              <div class="my-3">
                <label for="display-4">Email address</label>
                <input
                  type="email"
                  class="form-control"
                  id="floatingInput"
                  placeholder="name@example.com"
                  value={loginDetail.email}
                  onChange={(e)=>handleChange(e,'email')}
                />
              </div>
              <div class="my-3">
                <label for="floatingPassword display-4">Password</label>
                <input
                  type="password"
                  class="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                  value={loginDetail.passWord}
                  onChange={(e)=>handleChange(e,'password')}
                />
              </div>
              <div className="my-3">
                <p>New Here? <Link to="/register" className="text-decoration-underline text-info">Register</Link> </p>
              </div>
              <div className="text-center">
                <button class="my-2 mx-auto btn btn-dark" type="submit">
                  Login
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <Footer/>
    </>
  );
};

export default Login;
