import React from 'react'
import { Link } from 'react-router-dom';
import Jhampu from '../components/Jhampu';
import ProductCard from '../components/ProductCard';

const Home = () => {
  return (
    <>
    
    <div className='abcd'>
      <section className='home-wrapper-1 py-5' >
        <div className='container-xxl'>
            <div className='row'>
                <div className='col-25'>
                    <div className='main-banner position-relative p-3'>
                        <img
                        src='Cars.png'
                        className='img-fluid rounded-3'
                        alt='main banner'
                        />
                        <div className='main-banner-content position-absolute'>
                            <h4>Summon<br/><br/><br/> Luxury</h4>

                        </div>
                        

                    </div>

                </div>

            </div>

        </div>

      </section>
      



      <section className='home-wrapper-1 py-1 ' >
        <div className='container-xxl'>
            <div className='row'>
                <div className='col-25'>
                    <div className='main-banner position-relative p-1'>
                        <img
                        src='pxfuel.jpg'
                        className='img-fluid rounded-2'
                        alt='main banner'
                        />
                        <div className='h3n2 position-absolute'>
                            <h4>Go<br/><br/><br/> Economic</h4>

                        </div>

                    </div>

                </div>

            </div>

        </div>

      </section>

      </div>
   
      <section className='blog-wrapper py-5 home-wrapper-2'>
        <div className='container-xxl'>
          <div className='row'>
            <div className='col-12'>
              <h3>Featured Collection</h3>

            </div>
            {/* <ProductCard/>
            <Jhampu/> */}
            
          </div>

        </div>

      </section>
    </>
  )
}

export default Home;
