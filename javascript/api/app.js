document.addEventListener("DOMContentLoaded", function () {
    let countClick = 0;
    $(".btn-student").click(async function () {
        countClick++;
        if (countClick % 2 !== 0) {
            $("#display-table").html(`
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Birthday</th>
                            <th scope="col">Age</th>
                        </tr>
                    </thead>
                    <tbody class="show-student">
                    </tbody>
                </table>
            `);

            await fetchAllStudent();
        } else {
            $("#display-table").html("");
        }
    });
});

async function fetchAllStudent() {
    try {
        const response = await fetch("https://671a67e8acf9aa94f6aa84ee.mockapi.io/advance_js/students");
        console.log("Response: ", response);
        const data = await response.json();
        console.log("Response after convert data: ", data);

        data.forEach((student, index) => {
            const rowStudent = `
            <tr>
                <th scope="row">${student.id}</th>
                <td>${student.name}</td>
                <td>${student.birthday}</td>
                <td>${student.age}</td>
            </tr>`;
            $(".show-student").append(rowStudent);

            setTimeout(() => {
                $(".show-student tr:last").fadeIn(300); 
            }, index * 200);
        });

    } catch (error) {
        console.log("Have a error!", error);
        $(".show-student").html(`<p>Đã có lỗi xảy ra!!</p>`);
    }
}