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
    }
  ]
};

export default gaokaoManage
