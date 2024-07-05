import React from 'react'
import { Footer, Navbar } from "../components";
import { Link } from 'react-router-dom';
const AboutPage = () => {
  return (
    <>
      <Navbar />
      <div className="container my-3 py-3">
        <h1 className="text-center">About Us</h1>
        <hr />
        <p className="lead text-center">
        Welcome to To Wedding Planners , where dreams are woven into reality and love stories are brought to life.
        With years of experience and a passion for excellence, we embrace each wedding as a unique canvas, infusing it with elegance, sophistication, and sheer beauty. Allow us to be your guiding hand, your creative ally, and your steadfast support as we embark on this remarkable journey together
        </p>

        <h2 className="text-center py-4">Our Services</h2>
        <div className="row">
          <div className="col-md-3 col-sm-6 mb-3 px-3">
            <div className="card h-100">
              <img className="card-img-top img-fluid" src="https://images.unsplash.com/photo-1625244724120-1fd1d34d00f6?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="" height={160} />
              <div className="card-body">
                <h5 className="card-title text-center"><Link to="/product" className="text-decoration-underline text-info"></Link>Hotels</h5>
              </div>
            </div>
          </div>
          <div className="col-md-3 col-sm-6 mb-3 px-3">
            <div className="card h-100">
              <img className="card-img-top img-fluid" src="https://culinaryaffaire.com/wp-content/uploads/2021/08/Corporate-Catering.jpg" alt="" height={160} />
              <div className="card-body">
                <h5 className="card-title text-center">Catering</h5>
              </div>
            </div>
          </div>
          <div className="col-md-3 col-sm-6 mb-3 px-3">
            <div className="card h-100">
              <img className="card-img-top img-fluid" src="https://media.istockphoto.com/id/1186214696/photo/hindu-wedding-ritual-wherein-bride-and-groom-hand.jpg?s=2048x2048&w=is&k=20&c=c_TdMvcNkJxGecvC8kpTLjTuvWXJUIy8AqvnKmyQvws=" alt="" height={160} />
              <div className="card-body">
                <h5 className="card-title text-center">Photgraphy</h5>
              </div>
            </div>
          </div>
          <div className="col-md-3 col-sm-6 mb-3 px-3">
            <div className="card h-100">
              <img className="card-img-top img-fluid" src="https://media.istockphoto.com/id/1174342496/photo/flawlessly-done-makeup-for-a-big-day.jpg?s=2048x2048&w=is&k=20&c=AEEQAHU4GLFbOoMaDtW9eMqCqyxJ7F8DoE4Uxuc-rRc=" alt="" height={160} />
              <div className="card-body">
                <h5 className="card-title text-center">Bridal Makeup</h5>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  )
}

export default AboutPage