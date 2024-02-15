<template>
  <main>
    <Navbar />
    <div class="my-5">
      <div class="mx-auto w-25" style="max-width: 100%">
        <h2 class="texte-center mb-3">Add patient</h2>
        <form @submit.prevent="addPatient">
          <!-- Name -->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="name" class="form-label">Name</label>
              <input
                type="text"
                name="name"
                id="name"
                class="form-control"
                placeholder="Name"
                v-model="patient.name"
                required
              />
            </div>
          </div>

          <!-- Email -->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="email" class="form-label">E-mail</label>
              <input
                type="email"
                name="email"
                id="email"
                class="form-control"
                placeholder="patient@email.com"
                v-model="patient.email"
                required
              />
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="pno" class="form-label">Phone Number</label>
              <input
                type="tel"
                name="pno"
                id="pno"
                patter="[0-9]{3}-[0-9]{2}-[0-9]{3}"
                class="form-control"
                placeholder="123-45-789"
                v-model="patient.pno"
                required
              />
            </div>
          </div>

          <!-- gender -->
          <label for="gender" class="form-label">Gender</label>
          <div class="form-check">
            <input
              type="radio"
              name="gender"
              id="female"
              value="female"
              v-model="patient.gender"
              required
            />
            <label for="female" class="form-check-label">Female</label>
          </div>
          <div class="form-check">
            <input
              type="radio"
              name="gender"
              id="male"
              value="male"
              v-model="patient.gender"
              required
            />
            <label for="male" class="form-check-label">Male</label>
          </div>
          <div class="form-check">
            <input
              type="radio"
              name="gender"
              id="others"
              value="others"
              v-model="patient.gender"
              required
            />
            <label for="others" class="form-check-label">Others</label>
          </div>

          <div class="row">
            <div class="col-md-12 form-group">
              <input
                type="submit"
                value="Submit"
                class="btn btn primary w-100"
              />
            </div>
          </div>
        </form>
      </div>
    </div>
  </main>
</template>
<script>
import NavBar from "../components/NavBar.vue";

export default {
  name: "AddPatient",
  components: {
    NavBar,
  },

  data() {
    return {
      patient: {
        name: "",
        email: "",
        gender: "",
        pno: "",
      },
    };
  },
  methods: {
    addPatient() {
      fetch("http://localhost:8080/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.patient),
      }).then((data) => {
        console.log(data);
        this.$router.push("/");
      });
    },
  },
};
</script>
