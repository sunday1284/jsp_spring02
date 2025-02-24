//화살표 함수는 this가 없음
document.addEventListener("DOMContentLoaded",()=>{
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'dayGridMonth',
      initialDate : '2025-02-01',
      events: '../../prod/prodListFC.do',
      eventClick: function(info) {
        console.log(info);
        let prod = info.event.extendedProps; 
        // prod.prodId == event.id
        location.href = `../../prod/prodDetail.do?what=${prod.prodId}`;
      }
    });
    calendar.render();
});