import React from 'react'
import { Link } from 'react-router-dom';

const ProductCard = () => {
  return (
    <>
    <div className='col-3'>
        <div className='product-card'>
            <div className='product-image'>
                <img src='jaguar XF.jpg' alt="product image"/>
            </div>

            <div className='product-details'>
                <h6 className='brand'>Audi Q5</h6>
                <h5 className='product-title'>
                The SUV for a new generation. Convincing without being persuasive. Sportive without being unreasonable. Efficient driving pleasure.                </h5>
                <p className='price'>₹20,000/-</p>
            </div>
            <div className='action-bar position-absolute'>
                <div className='d-flex flex-column'>
                    <Link>
                    <img src='add-cart.svg' alt='addcart' />
                    </Link>

                </div>
            </div>
        </div>
 </div>
      
    </>
  )
}

export default ProductCard;
