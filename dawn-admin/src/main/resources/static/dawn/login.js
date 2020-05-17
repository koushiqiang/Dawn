$(function() {
  validateRule();
});


$.validator.setDefaults({
  submitHandler: function () {
    login();
  }
});

function login() {
  $.modal.loading($("#btnSubmit").data("loading"));
  var username = $.common.trim($("input[name='username']").val());
  var password = $.common.trim($("input[name='password']").val());
  var rememberMe = $("input[name='rememberme']").is(':checked');
  $.ajax({
    type: "post",
    url: ctx + "login",
    data: {
      "username": username,
      "password": password,
      "rememberMe": rememberMe
    },
    success: function (r) {
      if (r.code == 200) {
        location.href = ctx + 'index';
      } else {
        $.modal.closeLoading();
        $.modal.msg(r.msg);
      }
    }
  });
}

function validateRule() {
  var icon = "<i class='fa fa-times-circle'></i> ";
  $("#signupForm").validate({
    rules: {
      username: {
        required: true
      },
      password: {
        required: true
      }
    },
    messages: {
      username: {
        required: icon + "请输入您的用户名",
      },
      password: {
        required: icon + "请输入您的密码",
      }
    }
  })
}
