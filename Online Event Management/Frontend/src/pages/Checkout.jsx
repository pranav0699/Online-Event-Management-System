import React, { useState , useEffect } from 'react'
import { Footer, Navbar } from "../components";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { bookIn } from '../Services/userService';
import CurrencyRupeeIcon from '@mui/icons-material/CurrencyRupee';

const Checkout = () => {
  const state = useSelector((state) => state.handleCart);
  const [dateValue,setDateValue] = useState('');
  const [max_total_hour,setmax_total_hour] = useState('');
  const [no_of_guest,setNo_of_guest] = useState('');
  const [photographer,setPhotographer] = useState(false);
  const [makeupartist,setmakeupartist] = useState(false);
  const [payment_status,setpayment_status] = useState(false);
  const [amount,setamount] = useState('');
  
  const formData = {
    dateValue: [dateValue],
    max_total_hour: [max_total_hour],
    no_of_guest: [no_of_guest],
    photographer: [photographer],
    makeupartist: [makeupartist],
    payment_status: [payment_status],
    amount: [amount]
  };

  const EmptyCart = () => {
    return (
      <div className="container">
        <div className="row">
          <div className="col-md-12 py-5 bg-light text-center">
            <h4 className="p-3 display-5">No item in Cart</h4>
            <Link to="/" className="btn btn-outline-dark mx-4">
              <i className="fa fa-arrow-left"></i> Continue Shopping
            </Link>
          </div>
        </div>
      </div>
    );
  };
  
  const handleSubmit = (event)=>
  {
    
    event.preventDefault();
    setpayment_status(true);
    bookIn(formData).then((response)=>{console.log(response)
        
    }).catch((error) => {console.log(error)});
   
  }
 
  const handleDateChange = (event) =>
  {
    let subtotal = 0;
    state.map((item) => {
      return (subtotal += item.price * item.qty);
    });
    setamount(subtotal)
    setDateValue(event.target.value)
  }
  const handlehourChange = (event) =>
  {
    setmax_total_hour(event.target.value)
  }

  const handguestChange = (event) =>
  {
   setNo_of_guest(event.target.value);
  }

  const handlephotgrapherChange = (event) =>
  {
    setPhotographer(event.target.checked)
  }
  
  const handlephotmakeupartist = (event) =>
  {
    setmakeupartist(event.target.checked)
  }

  const handlepaymentstatus = (event) =>
  {
    setpayment_status(event.target.checked)
  }

  const ShowCheckout = () => {
    let subtotal = 0;
    let totalItems = 0;
    state.map((item) => {
      return (subtotal += item.price * item.qty);
    });

    state.map((item) => {
      return (totalItems += item.qty);
    });
    return (
      <>
      
        <div className="container py-5">
          <div className="row my-4">
            <div className="col-md-5 col-lg-4 order-md-last">
              <div className="card mb-4">
                <div className="card-header py-3 bg-light">
                  <h5 className="mb-0">Order Summary</h5>
                </div>
                <div className="card-body">
                  <ul className="list-group list-group-flush">
                    <li className="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                      Products ({totalItems})<span><CurrencyRupeeIcon/> {Math.round(subtotal)}</span>
                    </li>
                    <li className="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                      <div>
                        <strong>Total amount</strong>
                      </div>
                      <span>
                        <strong><CurrencyRupeeIcon/>{Math.round(subtotal)}</strong>
                      </span>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <div className="col-md-7 col-lg-8">
              <div className="card mb-4">
                <div className="card-header py-3">
                  <h4 className="mb-0">Booking Details</h4>
                </div>
                <div className="card-body">
                  <form className="needs-validation" onSubmit={handleSubmit}>
                    <div className="row g-3">
                      <div className="col-sm-6 my-1">
                        <label for="event_date" className="form-label">
                          Event Date
                        </label>
                        <input
                          type="date"
                          className="form-control"
                          id="event_date"
                          placeholder=""
                          required
                          value={dateValue}
                          onChange={handleDateChange}
                        />
                        <div className="invalid-feedback">
                          Valid first name is required.
                        </div>
                      </div>

                      <div className="col-sm-6 my-1">
                        <label for="totalhrs" className="form-label">
                          total hours
                        </label>
                        <input
                          type="number"
                          className="form-control"
                          id="totalHours"
                          placeholder="enter hours"
                          required
                          value={max_total_hour}
                          onChange={handlehourChange}
                        />
                        <div className="invalid-feedback">
                          Valid hrs required
                        </div>
                      </div>

                      <div className="col-12 my-1">
                        <label for="no_of_guest" className="form-label">
                          no of guest
                        </label>
                        <input
                          type="number"
                          className="form-control"
                          id="no of guest"
                          placeholder="0-999"
                          value={no_of_guest}
                          onChange={handguestChange}
                          required
                        />
                        <div className="invalid-feedback">
                          Please enter a valid guest count
                        </div>
                      </div>

                      <div className="col-12 my-1">
                        <label for="address" className="form-check">
                          Makeupartist
                        </label>
                        <input
                          type="checkbox"
                          className="form-check"
                          id="makeupartist"
                          checked = {makeupartist}
                          onChange={handlephotmakeupartist}
                          placeholder="yes / no"
                          required
                        />
                        <div className="invalid-feedback">
                          Please Select yes or no
                        </div>
                      </div>

                      <div className="col-12">
                        <label for="address2" className="form-label">
                          Photography Package
                        </label>
                        <input
                           className="form-check"
                           id="photographer"
                           type="checkbox"
                           checked={photographer}
                           onChange={handlephotgrapherChange}
                           required
                        />
                          <div className="invalid-feedback">
                          Please Select yes or no
                        </div>
                      </div>

                    
                    </div>

                    <hr className="my-4" />

                    <h4 className="mb-3">Payment</h4>

                    <div className="row gy-3">
                      <div className="col-md-6">
                        <label for="cc-name" className="form-label">
                          Name on card
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="cc-name"
                          placeholder=""
                          required
                        />
                        <small className="text-muted">
                          Full name as displayed on card
                        </small>
                        <div className="invalid-feedback">
                          Name on card is required
                        </div>
                      </div>

                      <div className="col-md-6">
                        <label for="cc-number" className="form-label">
                          Credit card number
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="cc-number"
                          placeholder=""
                          required
                        />
                        <div className="invalid-feedback">
                          Credit card number is required
                        </div>
                      </div>

                      <div className="col-md-3">
                        <label for="cc-expiration" className="form-label">
                          Expiration
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="cc-expiration"
                          placeholder=""
                          required
                        />
                        <div className="invalid-feedback">
                          Expiration date required
                        </div>
                      </div>

                      <div className="col-md-3">
                        <label for="cc-cvv" className="form-label">
                          CVV
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="cc-cvv"
                          placeholder=""
                          required
                        />
                        <div className="invalid-feedback">
                          Security code required
                        </div>
                      </div>
                    </div>

                    <hr className="my-4" />

                    <button
                      className="w-100 btn btn-primary "
                      type="submit" 
                    >
                      Confirm Booking
                    </button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  };
  return (
    <>
      <Navbar />
      <div className="container my-3 py-3">
        <h1 className="text-center">Checkout</h1>
        <hr />
        {state.length ? <ShowCheckout /> : <EmptyCart />}
      </div>
      <Footer />
    </>
  );
};

export default Checkout;
