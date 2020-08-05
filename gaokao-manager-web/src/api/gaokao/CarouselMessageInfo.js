import request from '@/utils/request';

export function getCarouselMessageInfoPage(query) {
    return request({
        url: '/api/carouselMessageInfo/listPage',
        method: 'post',
        data: query
    });
}

export function saveOrUpdateCarouselMessageInfo(form) {
    return request({
        url: '/api/carouselMessageInfo/saveOrUpdate',
        method: 'post',
        data: form
    });
}

export function changeCarouselStatus(id, status) {
    return request({
      url: '/api/carouselMessageInfo/changeStatus',
      method: 'post',
      data: { 'id': id, 'status': status }
    })
  }

export function deleteCarouselMessageInfo(id) {
    return request({
        url: '/api/carouselMessageInfo/delete',
        method: 'post',
        data: { 'id': id }
    });
}

export function getCarouselMessageInfoById(id) {
    return request({
        url: '/api/carouselMessageInfo/detail',
        method: 'post',
        data: { 'id': id }
    });
}