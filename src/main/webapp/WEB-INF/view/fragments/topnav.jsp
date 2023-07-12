<%@ include file="./vars.jsp" %>

    <div class="flex justify-between items-center h-24  pt-5 px-12">
        <div class="">
            <img src="${imageFolder}/logo.png" alt="" class="h-56 cursor-pointer ">
        </div>
        <div class="flex gap-2">
            <img src="${imageFolder}/Notif-removebg-preview.png" alt="" class="h-10 cursor-pointer hover:scale-125 ">
            <div class="h-10 relative">
                <img src="${imageFolder}/Untitled_design__8_-removebg-preview.png" alt=""
                    class="h-full cursor-pointer hover:scale-125">

                <div class="h-[100px] z-30 hidden w-[200px] p-2 top-full -left-[150px] rounded-lg bg-white absolute flex-col">
                    <div class="flex-1 border-b-2 border-neutral-900 flex justify-center items-center">
                        <p class="text-center w-full">${user.firstname} ${user.lastname}</p>
                    </div>
                    <div class="flex-1 flex justify-center items-center gap-5 w-full">
                        <a href="" class="border p-1 rounded">Update</a>
                        <a href="${logout}" class="flex ">
                            <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                xmlns="http://www.w3.org/2000/svg">
                                <path d="M8.502 11.5a1.002 1.002 0 1 1 0 2.004 1.002 1.002 0 0 1 0-2.004Z"
                                    fill="#333" />
                                <path
                                    d="M12 4.354v6.651l7.442-.001L17.72 9.28a.75.75 0 0 1-.073-.976l.073-.084a.75.75 0 0 1 .976-.073l.084.073 2.997 2.997a.75.75 0 0 1 .073.976l-.073.084-2.996 3.004a.75.75 0 0 1-1.134-.975l.072-.085 1.713-1.717-7.431.001L12 19.25a.75.75 0 0 1-.88.739l-8.5-1.502A.75.75 0 0 1 2 17.75V5.75a.75.75 0 0 1 .628-.74l8.5-1.396a.75.75 0 0 1 .872.74Zm-1.5.883-7 1.15V17.12l7 1.236V5.237Z"
                                    fill="#333" />
                                <path
                                    d="M13 18.501h.765l.102-.006a.75.75 0 0 0 .648-.745l-.007-4.25H13v5.001ZM13.002 10 13 8.725V5h.745a.75.75 0 0 1 .743.647l.007.102.007 4.251h-1.5Z"
                                    fill="#333" />
                            </svg>
                            Sign out
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>