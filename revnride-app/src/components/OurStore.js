import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Container } from 'react-bootstrap';

const OurStore = () => {

  const [cars, setCars] = useState([])
  const [search, setSearch] = useState([]);

  useEffect(() => {
    getAllCars();
  }, []);


  const getAllCars = () => {
    axios.get("http://localhost:8080/car/show-all-cars").then(

      (response) => {
        console.log(response)
        JSON.stringify(response);
        setCars(response.data);
        setSearch(response.data)
          ;
      },
      (error) => {
        console.log(error);
      }
    );
  };


  const searchItemByNAme = (e) => {

    setSearch(cars.filter((p) => {
      if (p.model.toUpperCase().includes(e.target.value.toUpperCase()))
        return p;

    }))


  }
  //check the data at console whethere it is recieved or not.

  return (
    <>
      <Container>
        <div className="input-group rounded" style={{ margin: "50px", }} dark >
          <input
            type="search"
            class="form-control rounded"
            placeholder="Search your product here"
            aria-label="Search"
            aria-describedby="search-addon"
            onChange={searchItemByNAme} />

        </div>
      </Container>

      <div>
        <h2>List of Cars</h2>
        <div className='container'>
          <div className='py-4'>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Mark</th>
                  <th scope="col">Model</th>
                  <th scope="col">Type</th>
                  <th scope="col">Production year</th>
                  <th scope="col">Color</th>
                  <th scope='col'>Price</th>
                  <th scope="col">Image</th>
                  <th scope="col">Localization</th>

                </tr>
              </thead>
              <tbody>
                {
                  cars.map((car, index) => (
                    <tr>
                      {/* <th scope="row" key={index}>{index + 1}</th> */}
                      <td>{car.idcar}</td>
                      <td>{car.mark}</td>
                      <td>{car.model}</td>
                      <td>{car.type}</td>
                      <td>{car.yearProduction}</td>
                      <td>{car.color}</td>
                      <td>{car.money}</td>
                      <td><img src={car.image} style={{ width: 100, height: 60 }} /></td>
                      <td>{car.localization.city}</td>
                    </tr>

                  ))
                }
              </tbody>
            </table>

          </div>
        </div>
      </div>




    </>
  )
}

export default OurStore
