import React, { useState , useEffect } from 'react'
import { Footer, Navbar } from "../components";
import { Link } from 'react-router-dom';
import { signUp } from '../Services/userService';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
const Register = () => {
    
    const [isSubmit, setIsSubmit] = useState(false);
    const[data,setData] = useState({
        contactNo : '',
        email : '',
        firstName : '',
        lastName : '',
        password :'',
        role : "USER"
      })

      const [formErrors,setFormErrors] = useState({});

      const handleChange = (event,property)=>{
      
        setData({...data,[property]:event.target.value});
      }
    
   
   
    useEffect(() => {
        console.log(formErrors);
        if (Object.keys(formErrors).length === 0 && isSubmit) {
            console.log(data);
            signUp(data)
                .then(response => {
                    console.log(response);
                    toast.success("registered successfully ");
                })
                .catch(error => {
                    console.log(error);
                    toast.success("registered successfully ");
                });
        }
    }, [formErrors]);
    

    const validate = (data)=>
    {
        const error = {}

        const regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/i;
        if(!data.contactNo)
          error.contactNo = "contact no is required";

        if(!data.email)
           error.email = "email is required"

        if(!data.firstName)
           error.firstName = 'first name is required'

        if(!data.lastName)
           error.lastName = " last name is required"

        if(!data.password)
           error.password = 'password is required '

        return error;
    }

      const formSubmit = (event) =>
      {
        event.preventDefault();
        signUp(data)
        .then(response => {
            console.log(response);
            toast.success("registered successfully ");
        })
        .catch(error => {
            console.log(error);
            toast.success("registered successfully ");
        });
        setFormErrors(validate(data));
        setIsSubmit(true);
        
      }
    return (
        <>
            <Navbar />
            
            <div className="container my-3 py-3">
                <h1 className="text-center">Register</h1>
                <hr />
                <div class="row my-4 h-100">
                    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
                        <form onSubmit={formSubmit}>
                            <div class="form my-3">
                                <label for="Name">First Name</label>
                                <input
                                    type="First_Name"
                                    class="form-control"
                                    id="FirstName"
                                    placeholder="Enter Your Name"
                                    onChange={(e)=>handleChange(e,'firstName')}
                                    required
                                />
                            </div>
                            <div className="form my-3">
                                <label for="Name">Last Name</label>
                                <input
                                    type="Last_Name"
                                    class="form-control"
                                    id="LastName"
                                    placeholder="Enter Your Name"
                                    onChange={(e)=>handleChange(e,'lastName')}
                                    required
                                />
                            </div>
                            <div className="form my-3">
                                <label for="PhoneNumber">Phone Number</label>
                                <input
                                    type="Phone_Number"
                                    class="form-control"
                                    id="PhoneNumber"
                                    placeholder="Enter Your Number"
                                    onChange={(e)=>handleChange(e,'contactNo')}
                                    required
                                />
                            </div>
                            <div className="form my-3">
                                <label for="Email">Email address</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="Email"
                                    placeholder="name@example.com"
                                    onChange={(e)=>handleChange(e,'email')}
                                    required
                                />
                            </div>
                            <div className="form  my-3">
                                <label for="Password">Password</label>
                                <input
                                    type="password"
                                    class="form-control"
                                    id="Password"
                                    placeholder="Password"
                                    onChange={(e)=>handleChange(e,'password')}
                                    required
                                />
                            </div>
                            <div className="my-3">
                                <p>Already has an account? <Link to="/login" className="text-decoration-underline text-info">Login</Link> </p>
                            </div>
                            <div className="">
                                <button class="my-2  btn btn-dark" type="submit" onClick={formSubmit} >
                                    Register
                                </button>
                                <button class="ml-3 my-2  btn btn-dark " type="reset"  >
                                     Reset
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    )
}

export default Register