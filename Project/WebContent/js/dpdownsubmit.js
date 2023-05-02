// Get the dropdown, textbox, submit button, and tab3 div
const dropdown = document.getElementById('dropdown');
const dropdownButton = dropdown.querySelector('.dropdown-toggle');
const dropdownMenu = dropdown.querySelector('.dropdown-menu');
const textbox = document.getElementById('textbox');
// const submitButton = document.getElementById('submit-button');
// const tab3 = document.getElementById('tab3');

// Set margin-top on textbox
textbox.style.marginTop = '10px';

// Add event listener to dropdown items to set dropdown button text
dropdownMenu.addEventListener('click', function(e) {
    if (e.target.tagName === 'A') {
        const selectedValue = e.target.getAttribute('data-value');
        dropdownButton.textContent = selectedValue;
    }
});

// Add event listener to submit button to add text to tab3
// submitButton.addEventListener('click', function() {
//     const output = document.createElement('p');
//     output.textContent = 'Hello, I just clicked';
//     document.querySelector('.tab-pane#tab3 .border .row').appendChild(output);
// });
