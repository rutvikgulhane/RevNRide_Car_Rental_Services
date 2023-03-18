import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import { useEffect } from "react";

import About from './pages/About';
import Contact from './pages/Contact';
import Login from './pages/Login'
import Signup from './pages/Signup';
import OurStore from './components/OurStore';
// import SpecialProduct from './components/SpecialProduct';
import Reservation from './pages/Reservation';
import Rentals from './components/Rentals';
import Admin from './components/Admin';
function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />} />
            <Route path='aboutUs' element={<About />} />
            <Route path='contact' element={<Contact />} />
            <Route path='login' element={<Login />} />
            <Route path='signup' element={<Signup />} />
            <Route path='ourstore' element={<OurStore />} />
            <Route path='reservation' element={<Reservation />} />
            <Route path='rentals' element={<Rentals />} />
            <Route path='admin' element={<Admin />} />


          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
