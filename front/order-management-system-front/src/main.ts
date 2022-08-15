import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from "axios";
import VueAxios from "vue-axios";
axios.defaults.withCredentials = true;
axios.defaults.baseURL = '/api';
import {library} from "@fortawesome/fontawesome-svg-core";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";
/* add some free styles */
import {faTwitter} from '@fortawesome/free-brands-svg-icons'
import {faUserSecret} from '@fortawesome/free-solid-svg-icons'
import {faSearch} from "@fortawesome/free-solid-svg-icons";
import {faMapMarked} from "@fortawesome/free-solid-svg-icons";
import {faCaretDown} from "@fortawesome/free-solid-svg-icons";
import {faMobile} from "@fortawesome/free-solid-svg-icons";
import {faStar} from "@fortawesome/free-solid-svg-icons";
import {faFilter} from "@fortawesome/free-solid-svg-icons";
import {faFileText} from "@fortawesome/free-solid-svg-icons";
import {faCompass} from "@fortawesome/free-solid-svg-icons";
import {faHome} from "@fortawesome/free-solid-svg-icons";
import {faUser} from "@fortawesome/free-solid-svg-icons";
import {} from '@fortawesome/free-regular-svg-icons'
/* add some pro styles */
/* add each imported icon to the library */
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
library.add(faFileText,faCompass,faHome,faUser,faFilter,faCaretDown,faStar,faMobile,faTwitter, faUserSecret,faSearch,faMapMarked,faCaretDown)
const app = createApp(App)
app.use(ElementPlus).use(VueAxios, axios).component('font-awesome-icon', FontAwesomeIcon).use(store).use(router).mount('#app')
