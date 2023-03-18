const About = (props) => {
  return (
      <>

          <div 
            id="aboutContainer">
              <h2>Our Dream</h2>
              <p id="about">
Our journey together has just started to build the world's iconic luxury brand in mobility and lifestyle. And we can't wait to show you where we are heading to.
Something unique and progressive is on the horizon, as you would expect from the ethereal nature of a startup. </p>


            


              <div class="beliefs">
                  <div class="image">
                      <img src="Images/belief-image2.svg" alt=""/>
                  </div>
                  <div class="content">
                      <p>Revv-N-Ride offers all luxury and premium car brands including Audi, BMW, Mercedes, Jaguar, Land Rover, Bentley, Rolls Royce and in all sorts of categories as Convertibles, Sedans, SUVs, Commuters and Limousines for travel, transport, rental or hire.</p>
                  </div>
              </div>


              <div class="beliefs">
                  <div class="image">
                      <img src="Images/belief-image3.svg" alt=""/>
                  </div>
                  <div class="content">
                      <p>We offer chauffeur-driven and self-drive luxury cars on rent in and around Pune. We cater to companies and individuals who appreciate the highest quality of assistance and require a fast and professional car rental service, whether it be for leisure, business, events or activities.  </p>
                  </div>
              </div>


              <div class="beliefs">
                  <div class="image">
                      <img src="Images/belief-image4.svg" alt=""/>
                  </div>
                  <div class="content">
                      {/* <h3>Open source is best </h3>
                      <p>Our curriculum and website are available on GitHub and we encourage students
                          to actually contribute to the project itself! </p> */}
                  </div>
              </div>
          </div>
      </>
  );
}
export default About;