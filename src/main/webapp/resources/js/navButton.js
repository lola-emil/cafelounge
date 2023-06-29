$(document).ready(function() {
  var currentURI = window.location.pathname;
  var buttonId = currentURI.replace(/\//g, '');
console.log(buttonId);

  $('.nav-btn').each(function() {
    if ($(this).attr('id') == buttonId) {
      $(this).addClass('bg-orange-500');
    }
  });
});

   function updateSelection(selection) {
    var dropdownSelection = document.getElementById('dropdown-selection');
    dropdownSelection.textContent = selection;

    var dropdownButton = document.getElementById('dropdown-button');
    var dropdownMenu = document.getElementById('dropdown-menu');
    dropdownMenu.classList.add('hidden');
  }

  document.addEventListener('click', function(event) {
    var dropdownButton = document.getElementById('dropdown-button');
    var dropdownMenu = document.getElementById('dropdown-menu');
    var targetElement = event.target;

    if (!dropdownButton.contains(targetElement)) {
      dropdownMenu.classList.add('hidden');
    } else {
      dropdownMenu.classList.toggle('hidden');
    }
  });