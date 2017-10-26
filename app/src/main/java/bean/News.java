package bean;

import java.util.List;

/**
 * Created by DELL on 2017/10/24.
 */

public class News {


    /**
     * date : 20171024
     * stories : [{"images":["https://pic4.zhimg.com/v2-3a6205444f2bf86428b1abf2f110588f.jpg"],"type":0,"id":9653549,"ga_prefix":"102418","title":"又是量杯又是秤的，做甜点，原料用量干嘛要那么精确？"},{"images":["https://pic4.zhimg.com/v2-ee740f35e247150da0c23b26720c543f.jpg"],"type":0,"id":9653741,"ga_prefix":"102417","title":"情侣因未与房东协商好退租押金，结果在出租屋放满死鱼引蛆\u2026\u2026"},{"images":["https://pic4.zhimg.com/v2-ef9a3c5c5b3aba6686ba13d3ec4f683b.jpg"],"type":0,"id":9653531,"ga_prefix":"102416","title":"保健品这东西，当饭吃、当药吃，都是错的"},{"images":["https://pic3.zhimg.com/v2-18f014cbb7c9ca1c57de40df96fb4b8e.jpg"],"type":0,"id":9653488,"ga_prefix":"102415","title":"为什么 AI 都打败李世石、柯洁了，还是没法帮我洗裤衩、做饭？"},{"images":["https://pic1.zhimg.com/v2-351a414cc1a6e4e9319c27bf567d18e8.jpg"],"type":0,"id":9653668,"ga_prefix":"102414","title":"印度送餐产业：多少商学院和大企业想学习，却很难复制"},{"images":["https://pic1.zhimg.com/v2-a86a08c54d44ff54f21ae7e108a11d28.jpg"],"type":0,"id":9653602,"ga_prefix":"102413","title":"「女性读研大多是混个文凭准备就业」，不知不觉就被统计歧视了"},{"images":["https://pic3.zhimg.com/v2-df62676146a39c0e35b583735f9a7b16.jpg"],"type":0,"id":9652899,"ga_prefix":"102412","title":"大误 · Siri 还有几个隐藏技能"},{"images":["https://pic2.zhimg.com/v2-110681fd6816cb2aecf8b675e42efbb1.jpg"],"type":0,"id":9653611,"ga_prefix":"102411","title":"25% 的进口关税免不了，但特斯拉在华独资建厂或许是最好的结果"},{"images":["https://pic2.zhimg.com/v2-fadc5a56094dd981d770a9f45a0704a5.jpg"],"type":0,"id":9653422,"ga_prefix":"102410","title":"壁纸网站经常见的星空大片，其实只是风光摄影的冰山一角"},{"images":["https://pic4.zhimg.com/v2-5aa1f1a7c72c540d9c93f6bb5f67831f.jpg"],"type":0,"id":9653467,"ga_prefix":"102409","title":"「最坏的脾气，不就应该留给最亲的人吗？」"},{"images":["https://pic3.zhimg.com/v2-6b552d29b6621c791701d3bd40518d92.jpg"],"type":0,"id":9653430,"ga_prefix":"102408","title":"为什么 go 的过去式是 went？"},{"images":["https://pic3.zhimg.com/v2-84980650ae87688b0d0aaae26894c5fe.jpg"],"type":0,"id":9653543,"ga_prefix":"102407","title":"煮饭煮出了工匠精神？仙人摇摇头，「你们又给我加戏」"},{"images":["https://pic2.zhimg.com/v2-6dd444c13909d083bc315bd1a9e8a4ed.jpg"],"type":0,"id":9653580,"ga_prefix":"102407","title":"老板：你不接受 996 上班制？呵呵，你就是吃不了苦"},{"images":["https://pic3.zhimg.com/v2-0de15d47477ce02f223b83ffd325d51e.jpg"],"type":0,"id":9653364,"ga_prefix":"102407","title":"某些「教玩家玩游戏」的行为，为什么那么招人恨？"},{"images":["https://pic2.zhimg.com/v2-17606e05073dd06c09788fcc69c50611.jpg"],"type":0,"id":9653347,"ga_prefix":"102406","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-035ee11f84858c12173d1004d49b5d88.jpg","type":0,"id":9653488,"ga_prefix":"102415","title":"为什么 AI 都打败李世石、柯洁了，还是没法帮我洗裤衩、做饭？"},{"image":"https://pic3.zhimg.com/v2-2d2d4ab0075d0fa149e52bcc170164e6.jpg","type":0,"id":9653668,"ga_prefix":"102414","title":"印度送餐产业：多少商学院和大企业想学习，却很难复制"},{"image":"https://pic1.zhimg.com/v2-d7100a0a2651468ad1c017bbcf0bcb64.jpg","type":0,"id":9653611,"ga_prefix":"102411","title":"25% 的进口关税免不了，但特斯拉在华独资建厂或许是最好的结果"},{"image":"https://pic3.zhimg.com/v2-787998a6c69aad5c0901464f8fb03bd2.jpg","type":0,"id":9653580,"ga_prefix":"102407","title":"老板：你不接受 996 上班制？呵呵，你就是吃不了苦"},{"image":"https://pic1.zhimg.com/v2-c1b0c1f745c38ebfbcf85b01f66a973c.jpg","type":0,"id":9653467,"ga_prefix":"102409","title":"「最坏的脾气，不就应该留给最亲的人吗？」"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-3a6205444f2bf86428b1abf2f110588f.jpg"]
         * type : 0
         * id : 9653549
         * ga_prefix : 102418
         * title : 又是量杯又是秤的，做甜点，原料用量干嘛要那么精确？
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public List<String> images;
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-035ee11f84858c12173d1004d49b5d88.jpg
         * type : 0
         * id : 9653488
         * ga_prefix : 102415
         * title : 为什么 AI 都打败李世石、柯洁了，还是没法帮我洗裤衩、做饭？
         */
        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }
}
