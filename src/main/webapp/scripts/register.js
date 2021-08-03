const error = document.querySelector('.error-text');
const errorDiv = document.querySelector('.error')

window.onload = () => {
    if (error.innerHTML === "") {
        errorDiv.style.visibility = 'hidden';
    } else {
        errorDiv.style.visibility = 'visible';
    }
};