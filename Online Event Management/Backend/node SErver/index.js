const express = require('express');
const app = express();
const PORT = 3000;
const cors = require('cors');

// Sample data for hotels
const hotelsCaterers = [
  {
    id: 1,
    title: 'SeaView',
    type : 'hotel',
    price: '20000',
   image :"https://media.istockphoto.com/id/104731717/photo/luxury-resort.jpg?s=612x612&w=0&k=20&c=cODMSPbYyrn1FHake1xYz9M8r15iOfGz9Aosy9Db7mI=",
},
  {
    id: 2,
    type : 'hotel',
    title: 'Jakarta',
    price: '11500',
    image: "https://img.freepik.com/premium-photo/view-hotel-swimming-pool-dusk_89386-3238.jpg",
  },

  {
    id: 3,
    type : 'hotel',
    title: 'hamilton',
    price: '30500',
    image: "https://t3.ftcdn.net/jpg/00/29/13/38/360_F_29133877_bfA2n7cWV53fto2BomyZ6pyRujJTBwjd.jpg",
  },


  {
    id: 4,
    type : 'hotel',
    title: 'RockFort',
    price: '115000',
    image: "https://media.istockphoto.com/id/119926339/photo/resort-swimming-pool.jpg?s=612x612&w=0&k=20&c=9QtwJC2boq3GFHaeDsKytF4-CavYKQuy1jBD2IRfYKc=",
  },
  
  
  {
    id: 5,
    type : 'caterers',
    title: 'Punnjabi',
    price: '15000',
    image: "https://i.pinimg.com/736x/6c/69/46/6c69467a6bbcb4619ac4af45701bcd5f.jpg",
  },
  
  {
    id: 6,
    type : 'caterers',
    title: 'southiess',
    price: '22000',
    image: "https://img3.exportersindia.com/product_images/bc-full/dir_104/3094599/south-indian-food-catering-1829772.jpg",
  },

  {
    id: 7,
    type : 'caterers',
    title: 'Italianao',
    price: '22000',
    image: "https://media.olivegarden.com/images/site/ext/pages/_promotions/catering/meal-combinations-1428x634.jpg",
  },

  {
    id: 8,
    type : 'caterers',
    title: 'Mexican',
    price: '25000',
    image: "https://images.squarespace-cdn.com/content/v1/5980a3d3cd0f687dc4dbfc0f/1574361240429-D3QV31U37K59NLVF8E6P/cateringfull2.jpg",
  },
  
];

// Sample data for caterers
app.use(cors());

// Route to get all hotels
app.get('/hotelsCaterers', (req, res) => {
  res.json(hotelsCaterers);
});


app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});