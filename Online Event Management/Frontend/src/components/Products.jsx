import React, { useState, useEffect } from "react";
import { useDispatch } from "react-redux";
import { addCart } from "../redux/action";
import CurrencyRupeeIcon from '@mui/icons-material/CurrencyRupee';
import Skeleton from "react-loading-skeleton";
import "react-loading-skeleton/dist/skeleton.css";



const Products = () => {
  const [data, setData] = useState([]);
  const [filter, setFilter] = useState(data);
  const [loading, setLoading] = useState(false);
  let componentMounted = true;

  const dispatch = useDispatch();

  const addProduct = (product) => {
    
    dispatch(addCart(product))
  }


  useEffect(() => {
    fetch('http://localhost:3000/hotelsCaterers')
      .then(response => response.json())
      .then(data => {
        setData(data);
      })
      .catch(error => {
        console.error('Error fetching hotels:', error);
      });
      return () => {
             componentMounted = false;
            };
  }, []);

  

  const Loading = () => {
    return (
      <>
        <div className="col-12 py-5 text-center">
          <Skeleton height={40} width={560} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
      </>
    );
  };

  const filterHotel = (cat) => {
    const updatedList = data.filter((item) => item.type === cat);
    setFilter(updatedList);
  }
  const filterCaterer = (cat) => {
    const updatedList = data.filter((item) => item.type === cat);
    setFilter(updatedList);
  }
  const ShowProducts = () => {
    return (
      <>
        <div className="buttons text-center py-5">
          <button className="btn btn-outline-dark btn-sm m-2" onClick={() => setFilter(data)}>All</button>
          <button className="btn btn-outline-dark btn-sm m-2" onClick={() => filterHotel("hotel")}> Hotels</button>
          <button className="btn btn-outline-dark btn-sm m-2" onClick={() => filterHotel("caterers")}> Caterers</button>
        </div>

        {filter.map((product) => {
          return (
            <div id={product.id} key={product.id} className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
              <div className="card text-center h-100" key={product.id}>
                <img
                  className="card-img-top p-3"
                  src={product.image}
                  alt="Card"
                  height={300}
                />
                <div className="card-body">
                  <h5 className="card-title">
                    {product.title}
                  </h5>
                 
                </div>
                <ul className="list-group list-group-flush">
                  <li className="list-group-item lead"> <CurrencyRupeeIcon/> {product.price}</li>
                </ul>
                <div className="card-body">
                  <button className="btn btn-dark m-1" onClick={() => addProduct(product)}>
                    Add to Cart
                  </button>
                </div>
              </div>
            </div>

          );
        })}
      </>
    );
  };
  return (
    <>
      <div className="container my-3 py-3">
        <div className="row">
          <div className="col-12">
            <h2 className="display-5 text-center">Our Services</h2>
            <hr />
          </div>
        </div>
        <div className="row justify-content-center">
          {loading ? <Loading /> : <ShowProducts />}
        </div>
      </div>
    </>
  );
};

export default Products;
