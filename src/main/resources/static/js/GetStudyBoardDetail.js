document.addEventListener("DOMContentLoaded", function () {
    const id = document.getElementById("id").value;

    fetch(`/api/get/detail/${id}`)
        .then(response => response.json())
        .then(data => {
            if(data && data.length > 0) {
                console.log(data);
            } else {
                console.log("error")
            }
        })
        .catch(error => {
            console.error("error: ", error);
            displayErrorMessage();
        })
})