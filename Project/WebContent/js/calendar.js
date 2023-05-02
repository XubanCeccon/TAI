let calendar = document.querySelector('.calendar')

const month_names = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']

isLeapYear = (year) => {
    return (year % 4 === 0 && year % 100 !== 0 && year % 400 !== 0) || (year % 100 === 0 && year % 400 ===0)
}

getFebDays = (year) => {
    return isLeapYear(year) ? 29 : 28
}

let selectedDays = [];

generateCalendar = (month, year) => {

    let calendar_days = calendar.querySelector('.calendar-days')
    let calendar_header_year = calendar.querySelector('#year')

    let days_of_month = [31, getFebDays(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    calendar_days.innerHTML = ''

    let currDate = new Date()
    if (!month) month = currDate.getMonth()
    if (!year) year = currDate.getFullYear()

    let curr_month = `${month_names[month]}`
    month_picker.innerHTML = curr_month
    calendar_header_year.innerHTML = year

    // get first day of month

    selectedDays = []; // Clear selectedDays at the start of each month

    let first_day = new Date(year, month, 1)

    for (let i = 0; i <= days_of_month[month] + first_day.getDay() - 1; i++) {
        let day = document.createElement('div');
        if (i >= first_day.getDay()) {
            day.classList.add('calendar-day-hover');
            day.innerHTML = i - first_day.getDay() + 1;
            day.innerHTML += `<span></span>
                  <span></span>
                  <span></span>
                  <span></span>`;
            if (i - first_day.getDay() + 1 === currDate.getDate() && year === currDate.getFullYear() && month === currDate.getMonth()) {
                day.classList.add('curr-date');
            }
            let currentDate = new Date(year, month, i - first_day.getDay() + 1);
            if (currentDate <= currDate) {
                day.classList.add('past-date');
            } else {
                day.addEventListener('click', () => {
                    let dayNum = i - first_day.getDay() + 1;
                    let confirmation = confirm(`Vous avez cliqu� sur le ${curr_month} ${dayNum}. Voulez-vous poser un jour de cong&eacute ou une absence?`);
                    if (confirmation) {
                        // Code to handle day off or absence
                        selectedDays.push(dayNum);
                        let minDay = Math.min(...selectedDays);
                        let maxDay = Math.max(...selectedDays);
                        let selectedDaysText = `Du ${minDay}/${curr_month}/${year} au ${maxDay}/${curr_month}/${year}`;
                        document.getElementById("selected-days-list").textContent = "Type de demande : en cours" + selectedDaysText;
                        document.getElementById("clicked-day").textContent = "Vous avez cliqu� sur les jours suivants : " + selectedDays.join(", ");
                        day.classList.add('selected');
                    } else {
                        // Code to handle cancel
                    }
                });
            }
            calendar_days.appendChild(day);
        }
    }




    let clearBtn = document.getElementById("clear-selection-btn");
    clearBtn.addEventListener('click', () => {
        selectedDays.forEach((day) => {
            let selectedDay = document.querySelector(`.calendar-day-hover:nth-child(${day + first_day.getDay() - 1})`);
            selectedDay.classList.remove('selected');
        });
        selectedDays = [];
        document.getElementById("clicked-day").textContent = "Vous n'avez s�lectionn� aucun jour.";
    });
}

let month_list = calendar.querySelector('.month-list')

month_names.forEach((e, index) => {
    let month = document.createElement('div')
    month.innerHTML = `<div data-month="${index}">${e}</div>`
    month.querySelector('div').onclick = () => {
        month_list.classList.remove('show')
        curr_month.value = index
        generateCalendar(index, curr_year.value)
    }
    month_list.appendChild(month)
})

let month_picker = calendar.querySelector('#month-picker')

month_picker.onclick = () => {
    month_list.classList.add('show')
}

let currDate = new Date()

let curr_month = {value: currDate.getMonth()}
let curr_year = {value: currDate.getFullYear()}

generateCalendar(curr_month.value, curr_year.value)

document.querySelector('#prev-year').onclick = () => {
    --curr_year.value
    generateCalendar(curr_month.value, curr_year.value)
}

document.querySelector('#next-year').onclick = () => {
    ++curr_year.value
    generateCalendar(curr_month.value, curr_year.value)
}
