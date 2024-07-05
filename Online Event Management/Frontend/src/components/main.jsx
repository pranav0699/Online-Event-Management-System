
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import React from "react";
import BannerBackground from "../Assets/home-banner-background.png";
import BannerImage from "../Assets/home-banner-image.png";
import { NavLink } from 'react-router-dom'

const Home = () => {
  return (

<div className="home-container">
      <div className="home-banner-container">
        <div className="home-bannerImage-container">
         <img src={BannerBackground} alt=""></img>
        </div>
        <div className="home-text-section">
          <h1 className="primary-heading">
           Turning dreams into reality, one wedding at a time."
          </h1>
          <p className="primary-text">
           our team thrives on curating unforgettable moments. From meticulous planners and creative designers to skilled coordinators and logistical wizards, each member brings a unique expertise to the table
          </p>
          <button className="secondary-button">
          <NavLink className="nav-link" to="/product"> <AddShoppingCartIcon/> Book now</NavLink>
          </button>
        </div>
        <div className="home-image-section">
          <img src={BannerImage} alt="" />
        </div>
      </div>
      <div className="primary-container"></div>
      </div>
  )
};


export default Home;
