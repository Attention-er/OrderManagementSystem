import {createStore} from 'vuex'

export default createStore({
    state: () => ({
        user: {},
        userId: -1,
        order_food_nums: []
    }),
    mutations: {
        removeUser(state){
          state.user = {};
          state.userId = -1
        },
        updateUser(state, user) {
            state.user = user;
            state.userId = user.id
        },
        count(state, food) {
            if (food.num == null || food.num == 0) {
                state.order_food_nums.push({
                    // @ts-ignore
                    foodId: food.id,
                    // @ts-ignore
                    businessId: food.businessId,
                    // @ts-ignore
                    userId: state.userId,
                    // @ts-ignore
                    price: food.price,
                    // @ts-ignore
                    totalPrice: food.price * 1,
                    // @ts-ignore
                    num: 1
                })
                food.num = 1;
            } else {
                state.order_food_nums.forEach((order, index) => {
                    // @ts-ignore
                    if (order.businessId === food.businessId && order.foodId === food.id) {
                        // @ts-ignore
                        order.num = food.num + 1;
                        // @ts-ignore
                        food.num = order.num;
                        // @ts-ignore
                        order.totalPrice = order.price * order.num;
                    }
                })
            }
        },
        subtraction(state, food) {
            try {
                for (let i = 0; i < state.order_food_nums.length; i++) {
                    // @ts-ignore
                    if (state.order_food_nums[i].foodId === food.id) {
                        // @ts-ignore
                        if (state.order_food_nums[i].num <= 1) {
                            state.order_food_nums.splice(i, 1);
                            food.num = 0;
                            throw new Error();
                        } else {
                            // @ts-ignore
                            state.order_food_nums[i].num = --food.num;
                            // @ts-ignore
                            state.order_food_nums[i].totalPrice = state.order_food_nums[i].price * state.order_food_nums[i].num;
                        }
                    }
                }

            } catch (e) {
                return;
            }
        }
    },
    actions: {},
    getters: {
        getOrderByBusiness: (state) => (business_id: any) => {
            // @ts-ignore
            return state.order_food_nums.filter(order_item => order_item.businessId === business_id)
        },
        getOrderTotalPrice: (state) => (business_id: any) => {
            let sum = 0;
            state.order_food_nums.forEach(
                (order_item) => {
                    // @ts-ignore
                    if (order_item.businessId === business_id) {
                        // @ts-ignore
                        sum += order_item.totalPrice
                    }
                }
            )
            return sum
        },
        getOrderTotalNum: (state) => (business_id: any) => {
            let sum = 0;
            state.order_food_nums.forEach(
                (order_item) => {
                    // @ts-ignore
                    if (order_item.businessId === business_id) {
                        // @ts-ignore
                        sum += order_item.num;
                    }
                }
            )
            return sum
        },
        getItemNum: (state) => (food_id: any) => {
            let sum = 0;
            state.order_food_nums.forEach(
                (order_item) => {
                    // @ts-ignore
                    if (order_item.foodId === food_id) {
                        // @ts-ignore
                        sum = order_item.num
                        return sum;
                    }
                }
            )
            return sum;
        }


    }
    ,
    modules: {}
})
