function handleRadioChange(event) {
  const selectedValue = event.target.value;

  if (selectedValue === "women") {
    // 옵션 1이 선택된 경우
    // 다른 버튼의 선택을 해제합니다.
    document.querySelector(
      'input[name="radioGroup"][value="men"]'
    ).checked = false;
  } else if (selectedValue === "men") {
    // 옵션 2가 선택된 경우
    // 다른 버튼의 선택을 해제합니다.
    document.querySelector(
      'input[name="radioGroup"][value="women"]'
    ).checked = false;
  }
}

function handleCheckboxChange(event) {
  const checkboxes = document.querySelectorAll('input[name="checkboxGroup"]');
  let checkedCount = 0;

  checkboxes.forEach((checkbox) => {
    if (checkbox.checked) {
      checkedCount++;
    }

    if (checkedCount > 3) {
      event.target.checked = false;
    }
  });
}

// 아이디 중복확인 버튼 클릭 시
document.getElementById("checkUsername").addEventListener("click", function () {
  var username = document.getElementById("username").value;
  // 중복확인 로직을 추가하여 사용 가능s한 아이디인지 확인하고 결과를 usernameStatus 요소에 표시합니다.
  var isUsernameAvailable = checkUsernameAvailability(username);
  if (isUsernameAvailable) {
    document.getElementById("usernameStatu").textContent =
      "사용 가능한 아이디입니다.";
  } else {
    document.getElementById("usernameStatus").textContent =
      "이미 사용 중인 아이디입니다.";
  }
});

// 비밀번호 확인 체크
document
  .getElementById("confirmPassword")
  .addEventListener("input", function () {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    if (password !== confirmPassword) {
      document
        .getElementById("confirmPassword")
        .setCustomValidity("비밀번호가 일치하지 않습니다.");
    } else {
      document.getElementById("confirmPassword").setCustomValidity("");
    }
  });

// 전화번호 정규식 체크
document.getElementById("phone").addEventListener("input", function () {
  var phone = document.getElementById("phone").value;
  // 전화번호가 000-0000-0000 형태인지 확인하는 정규식 패턴입니다.
  var phonePattern = /^\d{3}-\d{4}-\d{4}$/;
  if (!phonePattern.test(phone)) {
    document
      .getElementById("phone")
      .setCustomValidity("올바른 전화번호 형식이 아닙니다. (000-0000-0000)");
  } else {
    document.getElementById("phone").setCustomValidity("");
  }
});

// 이메일 도메인 선택 시
document.getElementById("domain").addEventListener("change", function () {
  var domain = document.getElementById("domain").value;
  if (domain !== "") {
    document.getElementById("email").value += "@" + domain;
  } else {
    document.getElementById("email").value = "";
  }
});

// 아이디 중복 확인 로직 (임시로 구현한 예시 함수입니다.)
function checkUsernameAvailability(username) {
  // 실제로는 서버와 통신하여 아이디 중복 여부를 확인해야 합니다.
  // 이 함수를 구현하여 서버와의 통신 또는 데이터베이스 조회 등을 처리하면 됩니다.
  // 임시로 예시 함수를 구현하였습니다.
  var existingUsernames = ["john123", "amy456", "james789"];
  return !existingUsernames.includes(username);
}
