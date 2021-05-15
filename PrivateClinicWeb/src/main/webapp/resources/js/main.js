function deleteMedicine(medicineId) {
    if (confirm("Bạn có chắc chắn xóa loại thuốc này?") == true){
         fetch(`/PrivateClinicWeb/admin/medicine/${medicineId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            if (res.status == 200) {
                let d = document.getElementById(`medicine${medicineId}`);
                d.style.display = "none";
            } else {
                alert("Something wrong!!!");
            }
        })
    }
}

function deletePatient(patientId) {
    if (confirm("Bạn có chắc chắn xóa thông tin của bệnh nhân này?") == true){
         fetch(`/PrivateClinicWeb/admin/patient/${patientId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            if (res.status == 200) {
                let d = document.getElementById(`patient${patientId}`);
                d.style.display = "none";
            } else {
                alert("Something wrong!!!");
            }
        })
    }
}

function deleteEmployee(employeeId) {
    if (confirm("Bạn có chắc chắn xóa thông tin của nhân viên này?") == true){
         fetch(`/PrivateClinicWeb/admin/employee/${employeeId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            if (res.status == 200) {
                let d = document.getElementById(`employee${employeeId}`);
                d.style.display = "none";
            } else {
                alert("Something wrong!!!");
            }
        })
    }
}

function deleteAppointment(appointmentId) {
    if (confirm("Bạn có chắc chắn xóa thông tin của lịch hẹn này?") == true){
         fetch(`/PrivateClinicWeb/admin/appointment/${appointmentId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            if (res.status == 200) {
                let d = document.getElementById(`appointment${appointmentId}`);
                d.style.display = "none";
            } else {
                alert("Something wrong!!!");
            }
        })
    }
}

function deleteMedicalForm(medicalFormId) {
    if (confirm("Bạn có chắc chắn xóa thông tin của phiếu khám này?") == true){
         fetch(`/PrivateClinicWeb/admin/medicalForm/${medicalFormId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            if (res.status == 200) {
                let d = document.getElementById(`medicalForm${medicalFormId}`);
                d.style.display = "none";
            } else {
                alert("Something wrong!!!");
            }
        })
    }
}

function deleteBill(billId) {
    if (confirm("Bạn có chắc chắn xóa hóa đơn này?") == true){
         fetch(`/PrivateClinicWeb/admin/bill/${billId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            if (res.status == 200) {
                let d = document.getElementById(`bill${billId}`);
                d.style.display = "none";
            } else {
                alert("Something wrong!!!");
            }
        })
    }
}

