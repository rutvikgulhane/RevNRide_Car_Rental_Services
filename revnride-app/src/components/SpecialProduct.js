import React from 'react'


import { Link } from 'react-router-dom';

const SpecialProduct = () => {



  return (
    <div className='col-4'>

      <div className='special-product-card'>
        <div className='d-flex justify-content-between'>
          <div>
            <img src='Mercedescclass.png' alt="watch" />
          </div>
          <div className='special-product-content'>
            <h5 className='brand'>Mercedes</h5>
            <h6 className='title'>
              Mercedes c class
            </h6>

            <p className='price'>
              <span className='red-p'>rs20000</span>&nbsp;<strike>  rs25000</strike>
            </p>
            <Link><button class="button-86" role="button">Add to</button>
            </Link>
          </div>


        </div>

      </div>

    </div>

  )
}

export default SpecialProduct;
