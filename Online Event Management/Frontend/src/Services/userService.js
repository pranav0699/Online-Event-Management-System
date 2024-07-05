
import api from "./helper";

// export const signUp = (user) =>
// {
//     return api.post('/user/register',user).then((response)=>response.data)
// };

export const signUp = async (userData) => {
    try {
        
        
        const response = await fetch("http://localhost:8080/user/register", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });
        
        if (!response.ok) {
            throw new Error('Failed to sign up');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        throw error;
    }
};

export const signIn = async (userData) => {
    try {
      
        const response = await fetch("http://localhost:8080/user/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });
        
        if (!response.ok) {
            throw new Error('Failed to sign in');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        throw error;
    }
};

export const bookIn = async (userData) => {
    try {
      
        const response = await fetch("http://localhost:8080/booking/createBooking", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });
        
        if (!response.ok) {
            throw new Error('Failed to book');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        throw error;
    }
};

// export const signIn = (loginDetail) =>
// {
//     return api.post('/user/login',loginDetail).then((response)=>response.data);
// }