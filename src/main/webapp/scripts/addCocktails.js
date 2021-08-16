const newIngredientButton = document.querySelector('#add-ingredient');


Array.from(document.querySelectorAll('.set-amount')).map(b => {
    b.addEventListener('click', (event) => {
        event.preventDefault();
        const inp = b.parentElement.children;
        const name = inp[0].value.split(':').slice(0,-1).join();
        if (inp[1].value)
            inp[0].value = name.trim() + ' : ' + inp[1].value;
        inp[1].value = '';
    })
})

Array.from(document.querySelectorAll('.clear-amount')).map(b => {
    b.addEventListener('click', (event) => {
        event.preventDefault();
        const inp = b.parentElement.children;
        const name = inp[0].value.split(':').slice(0,-1).join()
        inp[0].value = name.trim() + ' : none'
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

checkForExistingName = (ingredient, amount) => {
    const existing = document.querySelector(`#${ingredient}`);
    console.log(ingredient,existing)
    if(existing){
        existing.value = existing.value.split(':').slice(0,-1).join() + ' : ' + amount;
        return true;
    }
    return false;
}


document.querySelector('#new-ingredient-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const ingredientName = document.querySelector('#ingredientName');
    const ingredientAmount = document.querySelector('#ingredientAmount');
    if(!ingredientAmount.value) ingredientAmount.value = 'none';

    if(!checkForExistingName(ingredientName.value, ingredientAmount.value)) {
        const node = `<input type="text" name='${ingredientName.value}' value='${ingredientName.value} : ${ingredientAmount.value}'
                                   readonly id="${ingredientName.value}">
                            <input type="text" placeholder="ingredient amount">
                    <input type="button" value="Set Amount" class='set-amount'>
                    <input type="button" value="Clear Amount" class='clear-amount'>`
        const newIng = document.createElement('div');
        newIng.innerHTML = node;
        document.querySelector('.ingredients').appendChild(newIng);

        const children = newIng.children;

        children[2].addEventListener('click', (e) => {
            const name = children[0].value.split(':').slice(0, -1).join();
            if (children[1])
                children[0].value = name.trim() + ' : ' + children[1].value;
            children[1].value = '';
        });
        children[3].addEventListener('click', (e) => {
            const name = children[0].value.split(':').slice(0, -1).join();
            children[0].value = name.trim() + ' : none';
        });
    }
    ingredientName.value = '';
    ingredientAmount.value = '';
    document.querySelector('#new-ingredient').style.display = 'none'
    newIngredientButton.style.display = 'block'
});

