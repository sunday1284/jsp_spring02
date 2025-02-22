<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Simple DataTables 스타일 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css">

<!-- Simple DataTables -->
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"></script>

<!-- html2pdf.js 라이브러리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.js"></script>

<table id="buyerTable" class="table datatable">
    <thead class="table-light">
        <tr>
            <th>일련번호</th>
            <th>제조사명</th>
            <th>분류</th>
            <th>소재지</th>
            <th>연락처</th>
            <th>이메일</th>
            <th>담당자</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty buyerList}">
            <c:forEach items="${buyerList}" var="buyer">
                <tr>
                    <td>${buyer.rnum }</td>
                    <td>${buyer.buyerName }</td>
                    <td>${buyer.lprod.lprodNm }</td>
                    <td>${buyer.buyerAdd1 }</td>
                    <td>${buyer.buyerComtel }</td>
                    <td>${buyer.buyerMail }</td>
                    <td>${buyer.buyerCharger }</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty buyerList }">
            <tr>
                <td colspan="7">등록된 제조사가 없음.</td>
            </tr>
        </c:if>
    </tbody>
</table>

<!-- Export 버튼 추가 -->
<div>
    <button onclick="exportCSV()">Export CSV</button>
    <button onclick="exportJSON()">Export JSON</button>
    <button onclick="exportTXT()">Export TXT</button>
    <button onclick="exportSQL()">Export SQL</button>
    <button onclick="exportPDF()">Export PDF</button> <!-- PDF 다운로드 버튼 -->
</div>

<script>
    // Simple DataTables 활성화
    const dataTable = new simpleDatatables.DataTable("#buyerTable");

    // 테이블 데이터 가져오기
    function getTableData() {
        let data = [];
        let headers = [];
        
        // 헤더 가져오기
        document.querySelectorAll("#buyerTable thead th").forEach(th => headers.push(th.innerText));
        data.push(headers.join(",")); // CSV 헤더 추가

        // 테이블 내용 가져오기
        document.querySelectorAll("#buyerTable tbody tr").forEach(tr => {
            let row = [];
            tr.querySelectorAll("td").forEach(td => row.push(td.innerText));
            data.push(row.join(",")); // CSV 행 추가
        });

        return data;
    }

    // 파일 다운로드 함수
    function downloadFile(content, fileName, mimeType) {
        const blob = new Blob([content], { type: mimeType });
        const link = document.createElement("a");
        link.href = URL.createObjectURL(blob);
        link.download = fileName;
        link.click();
        URL.revokeObjectURL(link.href);
    }

    // CSV 다운로드
    function exportCSV() {
        const data = getTableData().join("\n");
        const bom = "\uFEFF"; // UTF-8 BOM
        downloadFile(bom + data, "buyer_list.csv", "text/csv");
    }

    // JSON 다운로드
    function exportJSON() {
        let jsonData = [];
        let headers = [];
        
        // 헤더 가져오기
        document.querySelectorAll("#buyerTable thead th").forEach(th => headers.push(th.innerText));

        // 데이터 가져오기
        document.querySelectorAll("#buyerTable tbody tr").forEach(tr => {
            let rowData = {};
            let cells = tr.querySelectorAll("td");
            headers.forEach((header, index) => {
                rowData[header] = cells[index].innerText;
            });
            jsonData.push(rowData);
        });

        downloadFile(JSON.stringify(jsonData, null, 2), "buyer_list.json", "application/json");
    }

    // TXT 다운로드
    function exportTXT() {
        const data = getTableData().join("\n");
        const bom = "\uFEFF"; // UTF-8 BOM
        downloadFile(bom + data, "buyer_list.txt", "text/plain");
    }

    // SQL 다운로드
    function exportSQL() {
        let sqlStatements = [];
        let headers = [];

        // 헤더 가져오기
        document.querySelectorAll("#buyerTable thead th").forEach(th => headers.push(th.innerText));

        // 데이터 가져오기
        document.querySelectorAll("#buyerTable tbody tr").forEach(tr => {
            let values = [];
            tr.querySelectorAll("td").forEach(td => {
                values.push(`'${td.innerText.replace(''/''/g, "''")}'`);
            });
            sqlStatements.push(`INSERT INTO buyer_table (${headers.join(", ")}) VALUES (${values.join(", ")});`);
        });

        downloadFile(sqlStatements.join("\n"), "buyer_list.sql", "text/sql");
    }

    // PDF 다운로드
    function exportPDF() {
        const element = document.getElementById("buyerTable");

        const opt = {
            margin:       1,
            filename:     'buyer_list.pdf',
            html2canvas:  { scale: 2 },
            jsPDF:        { unit: 'mm', format: 'a4', orientation: 'portrait' }
        };

        html2pdf().from(element).set(opt).save();
    }
</script>
