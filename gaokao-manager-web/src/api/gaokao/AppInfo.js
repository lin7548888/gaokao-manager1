import request from '@/utils/request';

export function getAppInfoPage(query) {
    return request({
        url: '/api/appInfo/listPage',
        method: 'post',
        data: query
    });
}

export function saveOrUpdateAppInfo(form) {
    return request({
        url: '/api/appInfo/saveOrUpdate',
        method: 'post',
        data: form
    });
}

export function changeAppStatus(id, status) {
  return request({
    url: '/api/appInfo/changeStatus',
    method: 'post',
    data: { 'id': id, 'status': status }
  })
}

export function deleteAppInfo(id) {
    return request({
        url: '/api/appInfo/delete',
        method: 'post',
        data: { 'id': id }
    });
}

export function getAppInfoById(id) {
    return request({
        url: '/api/appInfo/detail',
        method: 'post',
        data: { 'id': id }
    });
}
