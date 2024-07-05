import React from 'react'
import { NavLink } from 'react-router-dom'
import { useSelector } from 'react-redux'
import Logo from '../Assets/Logo.png'
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
// np
const Navbar = () => {
    const state = useSelector(state => state.handleCart)
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-white py-2 sticky-top">
            <div className="container">
                <NavLink className="" to="/"> <img class="nav-logo-container" height={40} width={150} src={Logo} alt="" /> </NavLink>
                
                <button className="navbar-toggler mx-2" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="navbar-links-container" id="navbarSupportedContent">
                    <ul className="navbar-nav m-auto my-2 text-center">
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/">Home </NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/product">Services</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/about">About</NavLink>
                        </li>
                       
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/contact">Contact</NavLink>
                        </li>
                        <li className='nav-item'>
                        <NavLink to="/login" className="nav-link"> Login</NavLink>
                        
                        </li>
                        <li className='nav-item'>
                        <NavLink to="/register" className="nav-link">Register</NavLink>
                       
                         </li>
                            <li className='nav-item'>
                            <NavLink to="/cart" className="nav-link"> <AddShoppingCartIcon/> Cart ({state.length})  </NavLink>
                    
                            </li>
                            </ul>
                    </div>
                </div>

        </nav>
    )
}

export default Navbar