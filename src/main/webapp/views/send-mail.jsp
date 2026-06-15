<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gửi Email - Lab 5</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white">
                        <h4 class="card-title mb-0 text-center">ỨNG DỤNG GỬI EMAIL</h4>
                    </div>
                    <div class="card-body p-4">

                        <%
                            String msg = (String) request.getAttribute("message");
                            if (msg != null) {
                        %>
                            <div class="alert alert-info text-center" role="alert">
                                <%= msg %>
                            </div>
                        <% } %>

                        <form action="${pageContext.request.contextPath}/mail/send" method="post">

                            <div class="mb-3">
                                <label for="to" class="form-label">Người nhận (To):</label>
                                <input type="email" class="form-control" id="to" name="to"
                                       placeholder="VD: nguyenvana@gmail.com" required>
                            </div>

                            <div class="mb-3">
                                <label for="subject" class="form-label">Tiêu đề (Subject):</label>
                                <input type="text" class="form-control" id="subject" name="subject"
                                       placeholder="Nhập tiêu đề thư..." required>
                            </div>

                            <div class="mb-3">
                                <label for="body" class="form-label">Nội dung (Message):</label>
                                <textarea class="form-control" id="body" name="body" rows="5"
                                          placeholder="Nhập nội dung email tại đây..." required></textarea>
                            </div>

                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-success">Gửi Mail</button>
                                <button type="reset" class="btn btn-secondary">Nhập lại</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>