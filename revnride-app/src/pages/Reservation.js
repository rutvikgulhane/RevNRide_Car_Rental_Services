
// "id_user": 1,
//   "id_car": 1,
//     "dateto": "string",
//       "datefrom": "string",
//         "localization_end": "string",
//           "localization_start": "string"


import { Link, useNavigate } from 'react-router-dom';
import { useState } from "react";
import axios from 'axios';
import { toast } from "react-toastify";
// import { useNavigate } from "react-router-dom";



const Reservation = () => {

  var id = sessionStorage.getItem("userid");

  const [apiData, setApiData] = useState({ idUser: id, idCar: "", dateTo: "", dateFrom: "", localizationEnd: "", localizationStart: "" });

  let navigate = useNavigate();
  const token = sessionStorage.getItem('token');

  const config = {
    headers: { Authorization: `${token}` }
  };
  const bodyParameters = {
    key: apiData
  };


  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(config);
    console.log("API DATA => " + JSON.stringify(apiData));
    axios.post('http://localhost:8080/reservation/add', apiData, config).then(
      (response) => {
        console.log(response);
        JSON.stringify(response);
        toast.success("Car Rented Successfully");
        navigate("/ourstore");

      }).catch((error) =>
        console.log(error.response),
        // navigate("/reservation")
      );
  }

  const handleChange = (event) => {
    const { name, value } = event.target
    setApiData({ ...apiData, [name]: value })
  }

  return (
    <section className="home-wrapper-1 py-2">
      <div className="container-xxl">
        <div className="row">
          <div className="col-6">
            <form className="Auth-form" onSubmit={handleSubmit} style={{ marginTop: "10px" }}>
              <h3 className="Auth-form-title py-2"><b>Register here</b></h3>

              <div className="form-group mt-3" >
                <label style={{ textAlign: 'left' }}>User ID</label>
                <input
                  type="text"
                  name="idUser"
                  value={apiData.idUser}
                  onChange={handleChange}
                  className="form-control mt-1"
                  placeholder="Enter user id"
                />


                <label style={{ textAlign: 'left' }}>Car ID</label>
                <input
                  type="text"
                  name="idCar"
                  value={apiData.idCar}
                  onChange={handleChange}
                  className="form-control mt-1"
                  placeholder="Enter car id"
                />
              </div>


              <div className="form-group mt-2" >
                <label style={{ textAlign: 'left' }}>Date To</label>
                <input
                  type="date"
                  name="dateTo"
                  value={apiData.dateTo}
                  onChange={handleChange}
                  className="form-control mt-1"
                  placeholder="Enter Date To" />
              </div>
              <div className="form-group mt-2" >
                <label style={{ textAlign: 'left' }}>Date From</label>
                <input
                  type="date"
                  name="dateFrom"
                  value={apiData.dateFrom}
                  onChange={handleChange}
                  className="form-control mt-1"
                  placeholder="Enter Date From" />
              </div>



              <div className="form-group mt-2" >
                <label style={{ textAlign: 'left' }}>City TO</label>
                <input
                  type="text"
                  name="localizationEnd"
                  value={apiData.localizationEnd}
                  onChange={handleChange}
                  className="form-control mt-1"
                  placeholder="Enter Drop City"
                />
              </div>
              <div className="form-group mt-2" >
                <label style={{ textAlign: 'left' }}>City FROM</label>
                <input
                  type="text"
                  name="localizationStart"
                  value={apiData.localizationStart}
                  onChange={handleChange}
                  className="form-control mt-1"
                  placeholder="Enter Pickup City"
                />
              </div>


              <br></br>
              <button type="submit" className="btn btn-success" style={{ textAlign: 'right' }}>Reserve</button>

            </form>
          </div>

          {/* <div className="col-6">
            <img src="images/signup.png" className="img-fluid rounded-5" alt="signupbrand"></img>
          </div> */}
        </div>
      </div>
    </section>
  );
}
export default Reservation;