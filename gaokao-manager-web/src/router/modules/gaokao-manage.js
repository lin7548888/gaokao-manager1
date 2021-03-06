/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/views/layout/Layout'

const gaokaoManage = {
  path: '/gaokaoManage',
  component: Layout,
  alwaysShow: true,
  name: '高考管理',
  redirect: 'noredirect',
  meta: {
    title: '高考管理',
    icon: 'component',
    resources: 'gaokaoManage'
  },
  children: [
    {
      path: 'appInfo',
      component: () => import('@/views/gaokao-managerator/AppInfo'),
      name: 'APP管理',
      meta: { title: 'APP管理', icon: '', noCache: true, resources: 'appInfo' }
    },
    {
      path: 'banner',
      component: () => import('@/views/gaokao-managerator/Banner'),
      name: 'Banner管理',
      meta: { title: '轮播图管理', icon: '', noCache: true, resources: 'Banner' }
    },
    {
      path: 'carouselMessage',
      component: () => import('@/views/gaokao-managerator/CarouselMessage'),
      name: 'CarouselMessage管理',
      meta: { title: '最新动态管理', icon: '', noCache: true, resources: 'CarouselMessage' }
    },
    {
      path: 'userInfo',
      component: () => import('@/views/gaokao-managerator/UserInfo'),
      name: 'UserInfo管理',
      meta: { title: '用户管理', icon: '', noCache: true, resources: 'UserInfo' }
    }
  ]
};

export default gaokaoManage
