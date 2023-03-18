import React from 'react'
import { Link } from 'react-router-dom'

const Footer = () => {
  return (
    <>



        <footer className='py-1'></footer>
       <footer className='py-3'></footer>
       <footer className='py-3'>
        <div className='container-xxl'>
            <div className='row'>
            <div className='col-5 '>
                    <p className='az text-white' id='az'><h2>Contact us</h2>
                    <br/><h6>
                        Revv-N-Ride Store
                        No.1259, Meera Eastates,
                        Akurdi,Pune 411044<br/>
                        +97-7977281936
                    </h6>
                    </p>

                </div>
                <div className='col-12 '>
                    <p className='text-center text-white'>&copy;{new Date().getFullYear()} TrailBlaze developers</p>

                </div>

            </div>
        
        </div>
       </footer>
    </>
  )
}

export default Footer
