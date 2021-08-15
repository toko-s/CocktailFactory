const newIngredientButton = document.querySelector('#add-ingredient');


Array.from(document.querySelectorAll('.set-amount')).map(b => {
    b.addEventListener('click', (event) => {
        const inp = b.parentElement.children;
        const name = inp[0].value.split(':').slice(0,-1).reduce((prev,curr) => prev + curr, '');
        if (inp[1].value)
            inp[0].value = name + ': ' + inp[1].value;
        inp[1].value = '';
    })
})

Array.from(document.querySelectorAll('.clear-amount')).map(b => {
    b.addEventListener('click', (event) => {
        const inp = b.parentElement.children;
        const name = inp[0].value.split(':').slice(0,-1).reduce((prev,curr) => prev + curr, '')
        inp[0].value = name + ': none'
    })
})

newIngredientButton.addEventListener('click', () => {
    document.querySelector('#new-ingredient').style.display = 'block'
    newIngredientButton.style.display = 'none';
});

document.querySelector('#new-ingredient-cancel').addEventListener('click', () => {
    document.querySelector('#new-ingredient').style.display = 'none'
    newIngredientButton.style.display = 'block'
});


document.querySelector('#new-ingredient-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const ingredientName = document.querySelector('#ingredientName');
    const ingredientAmount = document.querySelector('#ingredientAmount');
    const node = `<input type="text" name='${ingredientName.value}' value='${ingredientName.value} : ${ingredientAmount}'
                               readonly >
                        <input type="text" placeholder="ingredient amount">
                <input type="button" value="Set Amount" class='set-amount'>
                <input type="button" value="Clear Amount" class='clear-amount'>`
    const newIng = document.createElement('div');
    newIng.innerHTML = node;
    document.querySelector('.ingredients').appendChild(newIng);

    const children = newIng.children;

    children[2].addEventListener('click', () => {
        const name = children[0].value.split(':').slice(0,-1).reduce((prev,curr) => prev + curr, '');
        if(children[1])
            children[0].value = name + ': ' + children[1].value;
        children[1].value = '';
    });
    children[3].addEventListener('click', () => {
        const name = children[0].value.split(':').slice(0,-1).reduce((prev,curr) => prev + curr, '');
        children[0].value = name + ': none';
    });

    ingredientName.value = '';
    document.querySelector('#new-ingredient').style.display = 'none'
    newIngredientButton.style.display = 'block'
});
