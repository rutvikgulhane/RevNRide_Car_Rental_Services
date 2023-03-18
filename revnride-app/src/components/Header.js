import React from 'react'
import { NavLink, Link } from 'react-router-dom';
const Header = () => {
    return (
        <>
            <header className='header-top-strip py-3' >
                <div className='container-xxl'>
                    <div className='row'>
                        <div className='col-6'>
                            <p className='text-white mb-0' >
                                Contact us to book your Test-ride today!!!
                            </p>
                        </div>
                        <div className='col-6'>
                            <p className='text-end text-white' >
                                Hotline: <a href='tel:+91 7977281936'> +91 7977281936</a>
                            </p>
                        </div>

                    </div>
                </div>
            </header>

            <header className='header-upper py-3'>
                <div className='container-xxl'>
                    <div className='row'>
                        <div className='col-2'>
                            <h1>
                                <Link to="/"><p className='text-white'>Revv-N-Ride</p>  </Link>
                            </h1>
                        </div>
                        <div className='col-5'>
                            <div className="input-group mb-3">
                                <input type="text" className="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2" />
                                <span className="input-group-text" id="basic-addon2">@example.com</span>
                            </div>
                        </div>
                        <div className='col-5'>
                            <div className='header-uppper-links d-flex align-items-center justify-content-between'>
                                <div>
                                    <Link>
                                        <img src="compare.svg" alt="compare" />
                                        <p className='text-white'>Compare</p>
                                    </Link>
                                </div>
                                <div>
                                    <Link>
                                        <img src="wishlist.svg" alt="wishlist" />
                                        <p className='text-white'>Favourites</p>
                                    </Link>
                                </div>
                                <div>
                                    <Link to={"/login"}>
                                        <img src="user.svg" alt="login" />
                                        <p className='text-white'>Login</p>
                                    </Link>
                                </div>
                                <div>
                                    <Link to="/rentals" class="loginInsted" >
                                        <img src="cart.svg" alt="cart" />
                                        <p className='text-white'>My Rentals</p>
                                    </Link>
                                </div>
                            </div >
                        </div>

                    </div>

                </div>
            </header>
            <header className='header-bottom py-3'>
                <div className='container-xxl'>
                    <div className='row'>
                        <div className='col-12'>
                            <div className='menu-bottom d-flex align-items-center'>
                                <div></div>
                                <div className='menu-links'>
                                    <div className='d-flex align-items-center gap-15'>
                                        <NavLink className="text-white" to="/">Home  &nbsp;&nbsp;&nbsp;&nbsp;</NavLink>
                                        <NavLink className="text-white" to="/ourStore">Our Store &nbsp;&nbsp; &nbsp;</NavLink>
                                        <NavLink className="text-white" to="/contact">Contact&nbsp;&nbsp;&nbsp;</NavLink>
                                        <NavLink className="text-white" to="/aboutUs">About us&nbsp;&nbsp;&nbsp;</NavLink>
                                        <NavLink className="text-white" to="/reservation">Rent-A-Car</NavLink>


                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                </div>

            </header>
        </>
    )
}

export default Header;
