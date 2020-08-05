import request from '@/utils/request';

export function getGlobalConfigPage(query) {
    return request({
        url: '/api/banner/listPage',
        method: 'post',
        data: query
    });
}

export function saveOrUpdateGlobalConfig(form) {
    return request({
        url: '/api/banner/saveOrUpdate',
        method: 'post',
        data: form
    });
}

export function deleteGlobalConfig(id) {
    return request({
        url: '/api/banner/delete',
        method: 'post',
        data: { 'id': id }
    });
}

export function getGlobalConfigById(id) {
    return request({
        url: '/api/banner/detail',
        method: 'post',
        data: { 'id': id }
    });
}