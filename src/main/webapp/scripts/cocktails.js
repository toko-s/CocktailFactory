const userid = document.querySelector('#userID').innerHTML;


Array.from(document.querySelectorAll(".fa-heart")).map(h => {
    h.addEventListener('click', async () => {
        if (!userid) {
            window.location = '/login';
            return;
        }
        let toSet = false;
        if (h.className.includes('fav')) {
            h.className = 'fa fa-heart'
        } else {
            h.className = 'fa fa-heart fav'
            toSet = true;
        }
        const id = h.parentElement.firstElementChild.id;
        await fetch(`http://localhost:8080/favourite?id=${id}&isFavourite=${toSet}`, {
            method: 'POST'
        });
    })
})

Array.from(document.querySelectorAll('.fa-star')).map(s => {
    s.addEventListener('click' , async () => {
        if (!userid) {
            window.location = '/login';
            return;
        }
        let vote = s.className.split(' ');
        vote = vote[vote.length-1];
        const id = s.parentElement.firstElementChild.id;
        await fetch(`http://localhost:8080/vote?id=${id}&vote=${vote}`, {
            method: 'POST'
        })
        location.reload();
    })
})