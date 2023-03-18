import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Container } from 'react-bootstrap';
import RentalCard from './RentalCard'

const Rentals = () => {

  const [reservations, setReservations] = useState([])
  const [search, setSearch] = useState([]);
  const token = sessionStorage.getItem('token');
  const config = {
    headers: { Authorization: `${token}` }
  };

  useEffect(() => {
    getAllReservations();
  }, []);

  const userid = sessionStorage.getItem('userid');
  const getAllReservations = () => {
    axios.get(`http://localhost:8080/reservation/get-all-reservations-under-user?id=${userid}`).then(

      (response) => {
        console.log(response)
        JSON.stringify(response);
        setReservations(response.data);
        setSearch(response.data)
          ;
      },
      (error) => {
        console.log(error);
      }
    );
  };


  const searchItemByNAme = (e) => {

    setSearch(reservations.filter((p) => {
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
        <h2>List of Reservations</h2>
        <div className='container'>
          <div className='py-4'>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope='col'>Rent ID</th>

                  <th scope="col">CarId</th>
                  <th scope="col">Mark</th>
                  <th scope="col">Model</th>
                  <th scope="col">Type</th>
                  <th scope="col">Production year</th>
                  <th scope="col">Color</th>
                  <th scope='col'>Price</th>
                  <th scope="col">Image</th>
                  <th scope="col">Localization</th>

                  <th scope="col">Date From</th>
                  <th scope="col">Date To</th>

                  <th scope="col">City From</th>
                  <th scope="col">City From</th>

                </tr>
              </thead>
              <tbody>
                {
                  reservations.map((reservation, index) => (
                    <tr key={index}>


                      <td>{reservation.idRent}</td>


                      <td>{reservation.carResponse.idcar}</td>
                      <td>{reservation.carResponse.mark}</td>
                      <td>{reservation.carResponse.model}</td>
                      <td>{reservation.carResponse.type}</td>
                      <td>{reservation.carResponse.yearProduction}</td>
                      <td>{reservation.carResponse.color}</td>
                      <td>{reservation.carResponse.money}</td>
                      <td><img src={reservation.carResponse.image} alt='car_image' style={{ width: 100, height: 60 }} /></td>
                      <td>{reservation.carResponse.localization.city}</td>

                      <td>{reservation.dateTo}</td>
                      <td>{reservation.dateFrom}</td>

                      <td>{reservation.localizationStart.city}</td>
                      <td>{reservation.localizationEnd.city}</td>

                      <td>{reservation.price}</td>

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

export default Rentals
