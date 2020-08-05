import request from '@/utils/request';

export function getUserInfoPage(query) {
    return request({
        url: '/api/userInfo/listPage',
        method: 'post',
        data: query
    });
}

export function saveOrUpdateUserInfo(form) {
    return request({
        url: '/api/userInfo/saveOrUpdate',
        method: 'post',
        data: form
    });
}

export function changeUserInfoStatus(id, status) {
    return request({
      url: '/api/userInfo/changeStatus',
      method: 'post',
      data: { 'id': id, 'status': status }
    })
  }

export function deleteUserInfo(id) {
    return request({
        url: '/api/userInfo/delete',
        method: 'post',
        data: { 'id': id }
    });
}

export function getUserInfoById(id) {
    return request({
        url: '/api/userInfo/detail',
        method: 'post',
        data: { 'id': id }
    });
}