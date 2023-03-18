import React from "react";
import ReactStars from "react-stars";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";
import Header from "./Header";

const CarCard = ({ car }) => {
    // console.log("------>" + key);
    return (
        <>
            <div className='store-wrapper home-wrapper-2 py-5'>
                <div className="container-xxl">
                    <div className="row text-center">
                        <div className="col-6">



                            <Link to={"http://localhost:8080/car/get-car"}>
                                <div className="col-3">
                                    <div className="product-card position-relative">

                                        <div className="product-image">
                                            {/* <img src={car.image} alt="product image"></img> */}

                                        </div>
                                        <div className="product-details">
                                            <h3 className="brand">{car.mark}</h3>
                                            <h3 className="product-title">
                                                <i>{car.model}</i>
                                            </h3>

                                            <p className="price">₹{car.type}</p>
                                            <p className="price">₹{car.money}</p>
                                        </div>
                                    </div>
                                </div>
                            </Link>

                            {/* <ReactStars
        count={5}
        size={24}
        value="3"
        edit="3"
        activeColor="#ffd700"
    /> */}

                        </div>

                        <div className="col-6">
                            <ReactStars
                                count={5}
                                size={24}
                                value="3"
                                edit="3"
                                activeColor="#ffd700"
                            />
                        </div>

                    </div>
                </div>
            </div>

        </>
    )
}

export default CarCard;
