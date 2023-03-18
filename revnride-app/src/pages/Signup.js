import { Link, Navigate } from 'react-router-dom';
import { useState } from "react";
import axios from 'axios';
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";



const Signup = (props) => {

    const [apiData, setApiData] = useState({ username: "", email: "", password: "" });
    let navigate = useNavigate();
    const savedata = (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/register', apiData).then(
            (response) => {
                console.log(response);
                JSON.stringify(response);
                toast.success("You have been Registered successfully");
                navigate("/login");

            }).catch((error) =>
                console.log(error.response),
                {
                    "firstName": "Please check FirstName cannot be less than 4 letters"

                }
            );
    }

    const handleChange = (event) => {
        const { name, value } = event.target
        setApiData({ ...apiData, [name]: value })
        console.log(apiData);
    }

    return (
        <div className='signup-bg' >

            <div id="signupContainer">
                <form method="post" onSubmit={savedata} class="signup-form">
                    <p>Signup</p>

                    <div class="row">
                        <div class="sub-row" id="wide">
                            <label for="">Username</label>
                            <input type="text" name="username" onChange={handleChange} placeholder="user_name" required />
                        </div>
                    </div>
                    <div class="row">
                        <div class="sub-row" id="wide">
                            <label for="">Email</label>
                            <input type="email" name="email" onChange={handleChange} placeholder="Sendurmon@gmail.com" required />
                        </div>
                    </div>
                    <div class="row">
                        <div class="sub-row">
                            <label for="">Password</label>
                            <input type="password" name="password" id="" onChange={handleChange} placeholder="*******" required />
                        </div>
                    </div>
                    <div class="row-submit">
                        <input type="submit" id="submit" />
                    </div>
                    <Link to="/login" class="loginInsted">Login Instead?</Link>
                </form>
            </div>

        </div>
    );
}
export default Signup;